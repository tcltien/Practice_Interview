package com.tl.hotel.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App {
	static List<Integer> arrivals = new ArrayList<Integer>();
	static List<Integer> departures = new ArrayList<Integer>();

	public static void main(String[] args) {
		init();
		System.out.println(hotelReservation(arrivals, departures, 1));
	}

	public static void init() {
		arrivals = Arrays.asList(1, 3, 5);
		departures = Arrays.asList(2, 6, 10);
    }

	public static String hotelReservation(List<Integer> arrivals, List<Integer> departures, int k) {
		// Collection of events
		Map<Integer, Integer> events = new HashMap<>();
		// Number of rooms
		int n = arrivals.size();
		for (int i = 0; i < n; i++) {
			int arrival = arrivals.get(i);
			int departure = departures.get(i);
			// Add one during an arrival
			Integer current = events.get(arrival);
			events.put(arrival, current == null ? 1 : current + 1);
			// Remove one during a departure
			current = events.get(departure);
			events.put(departure, current == null ? -1 : current - 1);
		}
		// Sort the map
		Map<Integer, Integer> sortedEvents = new TreeMap<>(events);
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : sortedEvents.entrySet()) {
			count += entry.getValue();
			// If the current count exceeds the maximum number of rooms
			if (count > k) {
				return "false " + entry.getKey();
			}
		}
		return "true";
	}
}
