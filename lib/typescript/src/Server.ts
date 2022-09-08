import {Configuration, Inject} from "@tsed/di";
import {PlatformApplication} from "@tsed/common";
import "@tsed/platform-express"; // /!\ keep this import
import bodyParser from "body-parser";
import compress from "compression";
import cookieParser from "cookie-parser";
import methodOverride from "method-override";
import cors from "cors";
import "@tsed/ajv";
import {config, rootDir} from "./config";

@Configuration({
  ...config,
  acceptMimes: ["application/json"],
  httpPort: process.env.PORT || 8080,
  httpsPort: false, // CHANGE
  mount: {
    "/": [
      `${rootDir}/controllers/**/*.ts`
    ]
  },
  statics: {
    "/": [
      {
        root: `${rootDir}/public`,
        // ... statics options
      }
    ]
  },
  exclude: [
    "**/*.spec.ts"
  ]
})

export class Server {
  @Inject()
  app: PlatformApplication;

  @Configuration()
  settings: Configuration;

  $beforeRoutesInit(): void {
    this.app
      .use(cors())
      .use(cookieParser())
      .use(compress({}))
      .use(methodOverride())
      .use(bodyParser.json())
      .use(bodyParser.urlencoded({
        extended: true
      }));
  }
}