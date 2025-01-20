package com.mycompany.testgiocosedie;

class Posto {
    private boolean occupato;
	
    public Posto(){
        occupato = false;
    }

    public synchronized boolean libero() {
        return !occupato;
    }

    public synchronized boolean occupa() {
        if (!occupato){
            occupato = true;
            return true;
        } else
            return false;
    }
}