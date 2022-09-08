import { PlatformTest } from "@tsed/common";
import SuperTest from "supertest";
import { IsOptimal } from "../controllers/IsOptimal";
import { Server } from "../Server";

describe("security", () => {
  let request: SuperTest.SuperTest<SuperTest.Test>;

  beforeEach(PlatformTest.bootstrap(Server, {
    mount: {
      "/": [IsOptimal]
    }
  }));
  beforeEach(() => {
    request = SuperTest(PlatformTest.callback());
  });

  afterEach(PlatformTest.reset);

  it("GET int32.MAX_VALUE after centiseconds, should require a reboot", async () => {
     const response = await request.get("/isoptimal?days=249").expect(200);

     expect(response.text).toEqual("[i] Reboot required");
  });

  it("GET int32.MAX_VALUE, should require a reboot", async () => {
    const response = await request.get("/isoptimal?days=2147483648").expect(200);

    expect(response.text).toEqual("[i] Reboot required");
  });

 it("GET int32.MIN_VALUE, should return 400", async () => {
  const response = await request.get("/isoptimal?days=-2147483649").expect(400);
 });
});
