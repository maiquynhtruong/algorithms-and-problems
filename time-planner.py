# Time planner 
# Implement a meeting planner that can schedule meetings between two persons at a time.

# Time is represented by Unix format (also called Epoch) - a positive integer holding the seconds since January 1st, 1970 at midnight. 

# Planner input:

# dur - Meeting duration in seconds (a positive integer).
# timesA, timesB - Availability of each person, represented by an array of arrays.
# Each sub-array is a time span holding the start (first element) and end (second element) times.
# You may assume that time spans are disjointed.
# Planner output:

# Array of two items - start and end times of the planned meeting, representing the earliest opportunity for the two persons to meet for a dur length meeting.
# If no possible meeting can be scheduled, return an empty array instead.

def planner(dur, timesA, timesB):
	timesA, timesB = sorted(timesA), sorted(timesB)
	pA, pB = 0, 0
	while pA < len(timesA) and pB < len(timesB):
		start = max(timesA[pA][0], timesB[pB][0])
		end = min(timesA[pA][1], timesB[pB][1])
		if end - start >= dur:
			return (start, end)
		elif timesA[pA][1] < timesB[pB][1]:
			pA += 1
		else: 
			pB += 1
	return ()
			
			
