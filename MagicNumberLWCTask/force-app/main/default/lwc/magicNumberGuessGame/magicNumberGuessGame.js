import { LightningElement, track } from 'lwc';

const MAX_ATTEMPTS = 3;

export default class MagicNumberGuessGame extends LightningElement {
    @track guess = 5;
    @track message;
    @track attempts;
    @track guessList = [];

    goalNumber;

    columns = [
        { label: 'Guess', fieldName: 'guess', type: 'number' },
        { label: 'Feedback', fieldName: 'message', type: 'text' },
    ];

    connectedCallback() {
        this.initGame();
    }

    initGame() {
        this.goalNumber = Math.floor(Math.random() * 10) + 1;
        this.message = 'Game started! Guess a number between 1 and 10.';
        this.attempts = 0;
        this.guessList = [];
    }

    handleGuessChange(event) {
        this.guess = event.target.value;
    }

    handleGuessSubmit() {
        this.attempts++;
        let feedback;
        if (this.guess == this.goalNumber) {
            feedback = 'Correct';
        } else if (this.guess < this.goalNumber) {
            feedback = 'Too low';
        } else {
            feedback = 'Too high';
        }
        this.message = feedback;
        this.guessList.push({ id: this.attempts, guess: this.guess, message: feedback });

        if (this.attempts >= MAX_ATTEMPTS) {
            this.message = `Game Over! The number was ${this.goalNumber}.`;
        }
    }

    handleRestart() {
        this.initGame();
    }
}
