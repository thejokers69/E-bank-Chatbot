package org.mundiapolis.ebankchatbot.config;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

@Component
public class RagDataLoader {
    @Value("classpath:/pdfs/MohamedLakssir.pdf")
    private Resource pdfResource;
    @Value("store-data-v1.json")
    private String storeFile;

    private JdbcClient jdbcClient;
    private VectorStore vectorStore;

    public RagDataLoader(JdbcClient jdbcClient, VectorStore vectorStore) {
        this.jdbcClient = jdbcClient;
        this.vectorStore = vectorStore;
    }

    //@Bean
    public SimpleVectorStore simpleVectorStore(@Qualifier("openAiEmbeddingModel") EmbeddingModel embeddingModel) {
        SimpleVectorStore vectorStore = new SimpleVectorStore(embeddingModel);
        String fileStore = Path.of("src", "main", "resources", "store")
                .toAbsolutePath()+"/"+storeFile;
        File file = new File(fileStore);
        if (file.exists()) {
            PagePdfDocumentReader pdfDocumentReader =
                    new PagePdfDocumentReader(pdfResource);
            List<Document> documents = pdfDocumentReader.get();
            TextSplitter textSplitter = new TokenTextSplitter();
            List<Document> chunks = textSplitter.split(documents);
            vectorStore.accept(chunks);
            vectorStore.save(file);
        } else {
            vectorStore.load(file);
        }
        return vectorStore;
    }
    @PostConstruct
    public void initStore(){
        Integer count = jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class).single();
        if (count ==0){
            PagePdfDocumentReader pdfDocumentReader =
                    new PagePdfDocumentReader(pdfResource);
            List<Document> documents = pdfDocumentReader.get();
            TextSplitter textSplitter = new TokenTextSplitter();
            List<Document> chunks = textSplitter.split(documents);
            vectorStore.add(chunks);
            System.out.println("Vector store initialized successfully");
        }

    }
}
