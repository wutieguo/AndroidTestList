package com.tieguo.test.Model;

import com.tieguo.test.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tieguo Wu on 1/15/2019.
 */

public class MovieDetail implements Serializable {
    public String name = "";
    public float score = 0;
    public ArrayList<Actor> actors = new ArrayList<>();
    public String description = "";
}
