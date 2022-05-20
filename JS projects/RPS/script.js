const game = ()=>{
let pScore = 0;
let cScore = 0;

 const startGame = () => {
    const playBtn = document.querySelector(".intro button");
    const introScreen = document.querySelector(".intro");
    const match = document.querySelector(".match");

    
    playBtn.addEventListener("click", () => {
        introScreen.classList.add("fadeOut");
        match.classList.add("fadeIn");
       
    });
};
const playMatch = () => {
    const options = document.querySelectorAll(".options button");
    const pHand = document.querySelector(".player-hand");
    const cHand = document.querySelector(".CPU-hand");
    const hands = document.querySelectorAll('.hands img');

    hands.forEach(hand => {
        hand.addEventListener("animationend",function(){
          console.log(1);
          this.style.animation = "";
            });
    });
    const cpuOptions = ["Rock","Paper","Scissors"];
options.forEach(option => {
 option.addEventListener("click", function() {
     const cpuNum = Math.floor(Math.random() * 3);
     const cpuChoice = cpuOptions[cpuNum];

     setTimeout(() =>{
        compareHands(this.textContent, cpuChoice);

        pHand.src = `assets/${this.textContent}.png`;
        cHand.src = `assets/${cpuChoice}.png`;
       
     },2000)
     
     pHand.style.animation = "shakePlayer 2s ease";
     cHand.style.animation = "shakeCPU 2s ease";

     //console.log(cpuChoice);
  });
 });
};



const updateScore = () => {
    const playerScore = document.querySelector(".player-score p");
    const cpuScore = document.querySelector(".comp-score p");
    playerScore.textContent = pScore;
    cpuScore.textContent = cScore;

}


const compareHands = (pChoice,cpuChoice) => {
const winner = document.querySelector(".winner");
if(pChoice === cpuChoice)
{
    winner.textContent = "TIE";
    return;
}

if(pChoice === "Rock")
{
    if(cpuChoice === "Scissors")
    {
        winner.textContent = "PLAYER WINS";
        pScore++;
        updateScore();
        return;
    }else{
        winner.textContent = "CPU WINS";
        cScore++;
        updateScore();
        return;
    }
}

if(pChoice === "Paper")
{
    if(cpuChoice === "Rock")
    {
        winner.textContent = "PLAYER WINS";
        pScore++;
        updateScore();
        return;
    }else{
        winner.textContent = "CPU WINS";
        cScore++;
        updateScore();
        return;
    }
}

if(pChoice === "Scissors")
{
    if(cpuChoice === "Paper")
    {
        winner.textContent = "PLAYER WINS";
        pScore++;
        updateScore();
        return;
    }else{
        winner.textContent = "CPU WINS";
        cScore++;
        updateScore();
        return;
    }
}

};

 startGame();
 playMatch();

};

game();