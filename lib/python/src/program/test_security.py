from django.test import TestCase, Client
from django.test.utils import setup_test_environment
from django.urls import reverse
from .utils import is_optimal

class ProgramSecurityTestCase(TestCase):
    def test_249_days_requires_reboot(self):
        res = self.client.get("/isoptimal/", {"days":"249"})
        self.assertEqual(res.status_code, 200)
        self.assertContains(res, "[i] Reboot is required")

    def test_1337_days_requires_reboot(self):
        res = self.client.get("/isoptimal/", {"days":"1337"})
        self.assertEqual(res.status_code, 200)
        self.assertContains(res, "[i] Reboot is required")

    def test_zero_should_return_httpForbidden(self):
        res = self.client.get("/isoptimal/", {"days":"0"})
        self.assertEqual(res.status_code, 400)

    def test_negative_should_return_httpForbidden(self):
        res = self.client.get("/isoptimal/", {"days":"-1"})
        self.assertEqual(res.status_code, 400)

    def test_null_should_return_httpForbidden(self):
        res = self.client.get("/isoptimal/", {"days":""})
        self.assertEqual(res.status_code, 400)
