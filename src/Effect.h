#ifndef Effect_h
#define Effect_h

#include "Force.h"


class Effect {

 public:

    virtual Force forceAt(int posX, int posY)  = 0;

 public:
    int posX;
    int posY;
};

#endif // Effect_h
