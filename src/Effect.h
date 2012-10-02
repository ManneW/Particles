#ifndef Effect_h
#define Effect_h

#include "Force.h"


class Effect {

 public:

    virtual Force forceAt(Integer posX, Integer posY)  = 0;

 public:
    Integer posX;
    Integer posY;
};

#endif // Effect_h
