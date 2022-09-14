from django.http import HttpResponse, Http404
from django.template import loader
from .utils import is_optimal

def index(request):
    return HttpResponse("[!] Connected to Boeing 787!<br>[?] Enter how many days this Boeing has been operational (1 to 248): http://localhost:8080/isoptimal?days=[1-248]: ")

def isoptimal(request):
    days = int(request.GET["days"])
    res = is_optimal(days)
    if(res):
        return HttpResponse(f"[i] Reboot is required")
    else:
        return HttpResponse(f"[i] System is optimal<br>Reboot is required in {248 - days} days")
