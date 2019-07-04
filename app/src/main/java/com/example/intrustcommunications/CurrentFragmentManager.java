package com.example.intrustcommunications;

public class CurrentFragmentManager {
    private int currentFragment;

    public CurrentFragmentManager(){
        currentFragment = 0;
    }

    public void setCurrentFragment(int id) {
        currentFragment = id;
    }

    public int getCurrentFragment() {
        return this.currentFragment;
    }
}
