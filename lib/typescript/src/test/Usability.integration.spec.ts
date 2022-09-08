import { PlatformTest } from "@tsed/common";
import SuperTest from "supertest";
import { Server } from "../Server";

describe("usability", () => {
  let request: SuperTest.SuperTest<SuperTest.Test>;

  beforeEach(PlatformTest.bootstrap(Server));
  beforeEach(() => {
    request = SuperTest(PlatformTest.callback());
  });

  afterEach(PlatformTest.reset);

  it("should call GET / and return status code 200", async () => {
     const response = await request.get("/").expect(200);
  });

  it("100 days, should NOT require a reboot", async () => {
     const response = await request.get("/isoptimal?days=100").expect(200);
     expect(response.text).toContain("[i] Reboot is required in 148 days");
  });

  it("248 days, should require a reboot", async () => {
     const response = await request.get("/isoptimal?days=248").expect(200);

     expect(response.text).toEqual("[i] Reboot required");
  });


});
