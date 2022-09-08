import {Controller, Get, QueryParams} from "@tsed/common";

@Controller("/")
export class Index {
  @Get("/")
   get() {
       return "[!] Connected to Boeing 787!<br>[?] Please enter how many days this Boeing has been online http://localhost:8080/isoptimal?days=[1-248]: "
    }
}
