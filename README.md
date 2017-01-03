# OPL_Cause_Effect_Chain

# colombo
State delta-debugging in Java. See Andreas Zeller's paper: [Isolating Cause-Effect Chains from Computer Programs](http://swtv.kaist.ac.kr/courses/cs750b-sw-model-checking-fall-06/cs750b-sw-model-checking-fall-06/p201-zeller.pdf)

## Steps
- [x] Retrieve the path to a Challenge Java class entered by the user and process the class with Spoon
- For each input given in the `getInputs()` method of the `Challenge`
  - [x] Use Bsh to evaluate every block of the `challenge` method with each given input
  - [ ] Build the trace (which is all the states variations from the beginning to the end of the method)
- [ ] Compute the differences between a passing and a failing state
- [ ] Build the cause-effect chain (straight-forward from the previous step)
