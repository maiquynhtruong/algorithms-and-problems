/**
Problem statement
a string s consists of only vowels: a, e, i, o, u
Find a subsequence in the string s such that it consists of all five vowels and is a sequence of 
one or more a's, followed by one or more e's, followed by one or more i's, followed by one or
more o's, followed by one or more u's.

Example: 			 a e i a a i o o o a a u u a e i o u
Longest subsequence: a e i     i o o o     u u         u -> Length = 10 

If such a subsequence can't be found, return 0;
*/
#include <bits/stdc++.h>
using namespace std;
int main() {
	string s = "aeiaaioooaauuaeiou";
	int n = s.size(), longest[n], last['z'+1], unique[n];
	longest[0] = 1;
	for (int i = 1; i < n; i++) {
		unique[i] = 1;
		if (s[i] == s[i-1]) {
			longest[i] = longest[i-1] + 1;
		} else {
			longest[i] = 1;
		}
	}
	for (int i = 0; i < n; i++) {
		if ('a' <= s[i]) {
			if (longest[last['a']] + 1 >= longest[s[i]]) {
				longest[i] = longest[last['a']] + 1;
				if (s[i] != 'a') unique[i] = max(unique[i], unique[last['a']] + 1);
				else unique[i] = max(unique[i], unique[last['a']]);
			} 
		}
		if ('e' <= s[i]) {
			if (longest[last['e']] + 1 >= longest[s[i]]) {
				longest[i] = longest[last['e']] + 1;
				if (s[i] != 'e') unique[i] = max(unique[i], unique[last['e']] + 1);
				else unique[i] = max(unique[i], unique[last['e']]);
			}
		}
		if ('i' <= s[i]) {
			if (longest[last['i']] + 1 >= longest[s[i]]) {
				longest[i] = longest[last['i']] + 1;
				if (s[i] != 'i') unique[i] = max(unique[i], unique[last['i']] + 1);
				else unique[i] = max(unique[i], unique[last['i']]);
			}
		}
		if ('o' <= s[i]) {
			if (longest[last['o']] + 1 >= longest[s[i]]) {
				longest[i] = longest[last['o']] + 1;
				if (s[i] != 'o') unique[i] = max(unique[i], unique[last['o']] + 1);
				else unique[i] = max(unique[i], unique[last['o']]);
			}
		}
		if ('u' <= s[i]) {
			if (longest[last['u']] + 1 >= longest[s[i]]) {
				longest[i] = longest[last['u']] + 1;
				if (s[i] != 'u') unique[i] = max(unique[i], unique[last['u']] + 1);
				else unique[i] = max(unique[i], unique[last['u']]);
			}
		}
		last[s[i]] = i;
	}
	int result = 0;
	for (int i = 0; i < n; i++) {
		if (unique[i] == 5 && result < longest[i]) {
			result = longest[i];
		}
	}
	return result;
}
