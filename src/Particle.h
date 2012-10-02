#ifndef Particle_h
#define Particle_h

class World;

class Particle {


 private:
    Integer posX;
    Integer posY;
    Integer vX;
    Integer vY;

 public:

    /**
     * @element-type World
     */
    World *myWorld;
};

#endif // Particle_h
