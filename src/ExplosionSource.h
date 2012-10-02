#ifndef ExplosionSource_h
#define ExplosionSource_h

#include "Source.h"

class ExplosionSource : public Source {
public:
    virtual void emitParticles();
};

#endif // ExplosionSource_h
