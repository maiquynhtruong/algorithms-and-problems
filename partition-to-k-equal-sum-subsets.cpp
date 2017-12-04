class Solution {
    // order not important, can sort
    // if sum divisible by k, can move on
public:
    bool checkDivisible(int sum, vector<int> &kNums) {
        for (int i = 0; i < kNums.size(); i++) {
            if (kNums[i] != sum) return false;
        }
        return true;
    }
    void printVector(vector<int> v) {
        for (int i = 0; i < v.size(); i++) cout << v[i] << " ";
        cout << "\n";
    }
    bool backtrack(int pos, int sum, vector<int> &kNums, vector<int> &nums) {
        cout << "pos= " << pos << "\n";
        printVector(kNums);
        if (pos == nums.size()) return checkDivisible(sum, kNums);
        bool res = false;
        for (int j = 0; j < kNums.size(); j++) {
            // res = res || backtrack(pos+1, sum, kNums, nums);
            if (!res && sum - kNums[j] >= nums[pos]) {
                kNums[j] += nums[pos];
                res = res || backtrack(pos+1, sum, kNums, nums);
                kNums[j] -= nums[pos];
            }
        }
        return res;
    }
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) { sum += nums[i];}
        vector<int> kNums (k, 0);
        if (sum % k != 0 || sum < k) return false; else sum /= k;
        return backtrack(0, sum, kNums, nums);
    }
};