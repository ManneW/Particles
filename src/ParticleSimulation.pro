#-------------------------------------------------
#
# Project created by QtCreator 2012-10-02T14:35:57
#
#-------------------------------------------------

QT       += core gui

TARGET = ParticleSimulation
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    World.cpp \
    WindEffect.cpp \
    Source.cpp \
    Particle.cpp \
    GravityEffect.cpp \
    Force.cpp \
    ExplosionSource.cpp \
    Effect.cpp \
    ConeSource.cpp

HEADERS  += mainwindow.h \
    World.h \
    WindEffect.h \
    Source.h \
    Particle.h \
    GravityEffect.h \
    Force.h \
    ExplosionSource.h \
    Effect.h \
    ConeSource.h

FORMS    += mainwindow.ui
