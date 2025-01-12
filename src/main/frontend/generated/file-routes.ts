// /Users/thejoker/IdeaProjects/E-Bank-Chatbot/src/main/frontend/generated/file-routes.ts
import {createRoute, createRoute as createRoute_1} from "@vaadin/hilla-file-router/runtime.js";
import type { AgnosticRoute as AgnosticRoute_1 } from "@vaadin/hilla-file-router/types.js";
import * as IndexPage from "../views/@index.js";
import * as ChatPage from "../views/@chat"
import * as LayoutPage from "../views/@layout";
import * as Person from  "../views/person";
const routes: readonly AgnosticRoute_1[] = [
    createRoute("", LayoutPage, [
        createRoute("", IndexPage),
        createRoute("chat", ChatPage),
        createRoute("person", Person)
    ]),
];
export default routes;
