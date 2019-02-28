#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <vector>
using namespace std; 

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> auxilary (nums);
        vector<int> answer;
        int temp;
        for(int i = 0; i < auxilary.size(); i++) {
            temp = target - auxilary[i];
            for(int j = i + 1; j < auxilary.size(); j++) {
                if(temp == auxilary[j]) {
                    answer.push_back(i);
                    answer.push_back(j);
                    return answer;
                }
            }
        }
        
        return auxilary;
    }
};