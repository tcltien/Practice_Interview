package com.tl.hotel.Hotel;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testhotelReservation_FalseAt7() {
		List<Integer> arrivals =  Arrays.asList(1, 2, 4, 5, 7);
		List<Integer> departures = Arrays.asList(3, 3, 10, 8, 9);
		assertEquals("false 7", App.hotelReservation(arrivals, departures, 2));
	}
    
    @Test
    public void testhotelReservation_FalseAt2() {
		List<Integer> arrivals =  Arrays.asList(1, 2, 4, 5, 7);
		List<Integer> departures = Arrays.asList(3, 3, 10, 8, 9);
		assertEquals("false 2", App.hotelReservation(arrivals, departures, 1));
	}
    
    @Test
    public void testhotelReservation_True() {
		List<Integer> arrivals =  Arrays.asList(1, 4, 5);
		List<Integer> departures = Arrays.asList(3, 5, 10);
		assertEquals("true", App.hotelReservation(arrivals, departures, 1));
	}
    
    @Test
    public void testhotelReservation_Doc() {
		List<Integer> arrivals =  Arrays.asList(1, 3, 5);
		List<Integer> departures = Arrays.asList(2, 6, 10);
		assertEquals("false 5", App.hotelReservation(arrivals, departures, 1));
	}
}
