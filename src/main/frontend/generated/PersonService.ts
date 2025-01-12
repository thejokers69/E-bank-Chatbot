import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import type Filter_1 from "./com/vaadin/hilla/crud/filter/Filter.js";
import type Pageable_1 from "./com/vaadin/hilla/mappedtypes/Pageable.js";
import client_1 from "./connect-client.default.js";
import type Person_1 from "./org/mundiapolis/ebankchatbot/entities/Person.js";
async function count_1(filter: Filter_1 | undefined, init?: EndpointRequestInit_1): Promise<number> { return client_1.call("PersonService", "count", { filter }, init); }
async function exists_1(id: number, init?: EndpointRequestInit_1): Promise<boolean> { return client_1.call("PersonService", "exists", { id }, init); }
async function get_1(id: number, init?: EndpointRequestInit_1): Promise<Person_1 | undefined> { return client_1.call("PersonService", "get", { id }, init); }
async function list_1(pageable: Pageable_1, filter: Filter_1 | undefined, init?: EndpointRequestInit_1): Promise<Array<Person_1>> { return client_1.call("PersonService", "list", { pageable, filter }, init); }
async function delete_1(id: number, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("PersonService", "delete", { id }, init); }
async function deleteAll_1(ids: Array<number>, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("PersonService", "deleteAll", { ids }, init); }
async function save_1(value: Person_1, init?: EndpointRequestInit_1): Promise<Person_1 | undefined> { return client_1.call("PersonService", "save", { value }, init); }
async function saveAll_1(values: Array<Person_1>, init?: EndpointRequestInit_1): Promise<Array<Person_1>> { return client_1.call("PersonService", "saveAll", { values }, init); }
async function getPagedPersons_1(page: number, size: number, init?: EndpointRequestInit_1): Promise<Array<Person_1>> { return client_1.call("PersonService", "getPagedPersons", { page, size }, init); }
export { count_1 as count, delete_1 as delete, deleteAll_1 as deleteAll, exists_1 as exists, get_1 as get, getPagedPersons_1 as getPagedPersons, list_1 as list, save_1 as save, saveAll_1 as saveAll };
