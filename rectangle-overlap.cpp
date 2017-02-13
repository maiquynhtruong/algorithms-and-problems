//http://www.geeksforgeeks.org/find-two-rectangles-overlap/
// Two rectangles overlap when one is not way above, below, too far to the right, or too the left of another

struct Point {
	int x, y;
};

bool checkOverlap(struct Point l1, struct Point r1, struct Point l2, struct Point r2) {
	// if one is completely to the left or to the right of the other
	if (l1.x > r2.x || l2.x > r1.x) 
		return false;
	// if one is completely above or below the other
	if (l1.y < r2.y || r1.y > l2.y)
		return false;
	return true;
}

int main(int argc, char const *argv[])
{
	struct Point l1 = {0, 10}, r1 = {10, 0};
	struct Point l2 = {5, 5}, r2 = {15, 0};
	if (checkOverlap(l1, r1, l2, r2))
		printf("%s\n", "Overlap");
	else
		printf("%s\n", "Not overlap");
	return 0;
}