using System.Net.Http;
using System.Net;
using System.Threading.Tasks;
using NUnit.Framework;
using Microsoft.AspNetCore.Mvc.Testing;

namespace program.Tests
{
    [TestFixture, Category("usability")]
    public class programUsabilityTest
    {
        WebApplicationFactory<Program>? webAppFactory = null;
        HttpClient? httpClient = null;
        HttpResponseMessage? response = null;

        [SetUp]
        public void Setup()
        {
            webAppFactory = new WebApplicationFactory<Program>();
            httpClient = webAppFactory.CreateDefaultClient();
        }


        [Test]
        public async Task test_health_return_httpOk()
        {
            if (httpClient is not null)
            {
                response = await httpClient.GetAsync("/v1.0/health");
                Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
            }
        }

        [Test]
        public async Task test_request_to_home_should_return_http_not_found()
        {
            if (httpClient is not null)
            {
                response = await httpClient.GetAsync("/v1.0/home/sec-game");
                string content = await response.Content.ReadAsStringAsync();
                Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
                Assert.That(content, Does.Contain("sec-game").IgnoreCase);
            }
        }

    }
}
