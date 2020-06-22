package com.rites.sample.dsa.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * company google facebook amazon
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/meeting-rooms-ii/
 * frequency 80%
 */
public class MeetingRooms {

    public static void main(String[] args) {
//        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals = {{6,15},{13, 20},{6, 17}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        // its a min heap of interval's end time
        PriorityQueue<MeetingRoom> heap = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int[] interval : intervals) {
            final MeetingRoom newMeeting = new MeetingRoom(interval);
            final MeetingRoom existing = heap.peek();
            if (existing != null && existing.end <= newMeeting.start) {
                // room can be occupied
                // pop and add
                heap.poll();
            }
            heap.add(newMeeting);
        }

        return heap.size();
    }

    static class MeetingRoom implements Comparable<MeetingRoom> {
        int start;
        int end;

        public MeetingRoom(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MeetingRoom)) return false;
            MeetingRoom that = (MeetingRoom) o;
            return start == that.start &&
                    end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(MeetingRoom that) {
            return this.end - that.end;
        }
    }
}
