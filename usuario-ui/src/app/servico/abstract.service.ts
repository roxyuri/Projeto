import { map, tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders, HttpResponse, HttpErrorResponse , HttpHeaderResponse} from '@angular/common/http';
import { ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs/Observable';


export class AbstractService {

    url: string = environment.url;
    public http: HttpClient;
    public extractData;
    handleError;
    constructor(httpParameter) {
        this.http = httpParameter;
    }

    postMethod(value, relativePath: String) {
        return this.http.post(this.url + relativePath, JSON.stringify(value), { headers: this.getHeaders() })
        .pipe(map(res => {
                JSON.parse(JSON.stringify(res || null));
                this.extractData = res;
            }
            )).toPromise()
            .then(this.extractData)

            .catch(this.handleError);
    }

    putMethod(value, relativePath: String) {
        return this.http.put(this.url + relativePath, JSON.stringify(value), { headers: this.getHeaders() })
        .pipe(map(res => {
                JSON.parse(JSON.stringify(res || null));
                this.extractData = res;
            }
            )).toPromise()
            .then(this.extractData)

            .catch(this.handleError);
    }

    getMethod(relativePath: string) {
        return this.http.get(this.url + relativePath , { headers: this.getHeaders() })
        .pipe(map(
            (res: any) =>  res));
    }

     getMethodJsonString(relativePath: string) {
        return this.http.get(this.url + relativePath)
        .pipe(map((res: any)  => res.text() ? res.json() : {}));
    }

    getMethodComException(relativePath: string) {
        return this.http.get(this.url + relativePath, { headers: this.getHeaders() })
            .pipe(map((res: any)  => res.json())).toPromise().catch(this.handleError);
    }

     postMethodComException(value, relativePath: String) {
        return this.http.post(this.url + relativePath, JSON.stringify(value), { headers: this.getHeaders() })
            .pipe(map((res: any) => res.json())).toPromise().catch(this.handleError);
    }

    getDownloadMethod(relativePath: String) {
        return this.http.get(this.url + relativePath, {  headers: this.getMultiPartHeaders() , responseType: 'arraybuffer'  } )
        .pipe( map(res => res));
    }

    deleteMethod(relativePath: String, value) {
        return this.http.delete(this.url + relativePath + value, { headers: this.getHeaders() })
            .pipe(map(res => {
                JSON.parse(JSON.stringify(res || null));
                this.extractData = res;
            }
            )).toPromise()
            .then(this.extractData)

            .catch(this.handleError);
    }

    getHeaders() {
        const headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        return headers;
    }

    getMultiPartHeaders() {
        const headers = new HttpHeaders();
        return headers;
    }

    getPerfil() {
        const currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
        console.log(currentUser);
        return currentUser.perfil;
    }

    getUsuario() {
        const currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
        return currentUser;
    }
}
