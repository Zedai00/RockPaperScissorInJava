# RockPaperScissors
Rock Paper Scissor Game In Java

## Implementation

### Computer Selection:
- Get a random number between 1 and 100
- Compare the number 
  - if less than 33 return rock
  - if greater than 66 return paper
  - if inbetween return scissor
    
### Player Selection
- Ask the use for its selection by prompt
- Turn it into lowerCase for comparison

### Play Round
- Play a single round by taking the player selection and computer selection as variable
- check both variable and compare them
- Condition for player Winning if given playerSelection and computerSelection
    - Rock > Scissor
    - Paper > Rock
    - Scissor > Paper
- Condition for player Losing if given playerSelection and computerSelection
    - Rock < Paper 
    - Paper < Scissor
    - Scissor < Rock
- return a string for three types of condition
    - Player Winning
    - Player Losing
    - Tie

### Game
- Take a variable turn to play that many times
- use playRound to play the rounds
- keep two score: playerScore and computerScore
- Score:
    - Increase playerScore if win
    - Increase computerScore if lose
    - Same if tie
- Repeat this for turn times
- Finally print the winner
    - if playerScore > computerScore
        - Win
    - if playerScore < computeScore
        - Lose
    - if playerScore = computeScore
        - Tie
    
