import { Injectable } from '@angular/core';
import { Todo } from './todo';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TodoService{
    private baseUrl = 'http://localhost:8080/';

    constructor(private http : Http){}

    getTodos(): Promise<Todo[]>{
        return this.http.get(this.baseUrl + 'todo/all')
            .toPromise()
            .then(response => response.json() as Todo[])
            .catch(this.handleError)
    }

    createTodo(todoData: Todo): Promise<Todo> {
        return this.http.post(this.baseUrl + '/todo/add/', todoData)
        .toPromise().then(response => response.json() as Todo)
        .catch(this.handleError);
    }

    updateTodo(todoData: Todo): Promise<Todo> {
        return this.http.put(this.baseUrl + '/todo/update/' + todoData.id, todoData)
        .toPromise()
        .then(response => response.json() as Todo)
        .catch(this.handleError);
    }

    deleteTodo(id: string): Promise<any> {
        return this.http.delete(this.baseUrl + '/todo/delete/' + id)
        .toPromise()
        .catch(this.handleError);
    }


    private handleError(error: any): Promise<any> {
        console.error('Some error occured', error);
        return Promise.reject(error.message || error);
    }
}