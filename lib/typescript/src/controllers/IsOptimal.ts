import {Controller, Get, QueryParams} from "@tsed/common";
const threshold = 248 * 86400 * 100

@Controller("/IsOptimal")
export class IsOptimal {
  @Get("/")
  get(@QueryParams('days') days: string) {
      var check = new Int32Array(1)
      check[0] = parseInt(days) * 86400 * 100
      if(check[0] >= threshold) {
          return "[i] Reboot required"
      }
      else {
          return "[i] System optimal<br>[i] Reboot is required in " + (248-parseInt(days)) + " days"
      }
   }
}