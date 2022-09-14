from django.test import TestCase, Client
from django.test.utils import setup_test_environment
from django.urls import reverse


class ProgramTestCase(TestCase):
    def test_100_days_is_system_optimal(self):
        res = self.client.get("/isoptimal/", {"days":"100"})
        self.assertEqual(res.status_code, 200)
        self.assertContains(res, "[i] System is optimal")

    def test_248_days_requires_reboot(self):
        res = self.client.get("/isoptimal/", {"days":"248"})
        self.assertEqual(res.status_code, 200)
        self.assertContains(res, "[i] Reboot is required")
