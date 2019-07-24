package com.example.intrustcommunications;

/**
 * Class used to define the current fragment.
 *
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class CurrentFragmentManager {
    private int currentFragment;

    /**
     * Empty constructor.
     * Set dashboard as default fragment.
     */
    public CurrentFragmentManager() {
        currentFragment = 10;
    }

    /**
     * Set the current fragment id.
     *
     * @param id fragment id.
     */
    public void setCurrentFragment(int id) {
        currentFragment = id;
    }

    /**
     * Get the current fragment id.
     *
     * @return the id of the current fragment.
     */
    public int getCurrentFragment() {
        return this.currentFragment;
    }
}
