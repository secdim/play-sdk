from django.urls import path
from . import views

urlpatterns = [
    # /program/
    path('', views.index, name='index'),
    # /program/1
    path('isoptimal/', views.isoptimal, name='isoptimal'),
]
