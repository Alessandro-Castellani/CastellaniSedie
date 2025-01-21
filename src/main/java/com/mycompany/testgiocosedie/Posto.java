package com.mycompany.testgiocosedie;

class Posto {
    private boolean occupato;
	
    public Posto(){
        occupato = false;
    }

    public synchronized boolean libero() {
        return !occupato;
    }

    public synchronized boolean occupa() { // gestisce da solo la mutua esclusione, evocando implicitamente NotifyAll()  
        if (!occupato){
            occupato = true;
            return true;
        } else
            return false;
    }
}
