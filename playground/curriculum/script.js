const title = document.getElementById('title');
const screw = document.getElementById("screw");
const screwImg = document.getElementById("screwImg");
const contentDiv = document.getElementById('contentDiv');
let isFallingDown = true;
let isGoingUp = false;
let randomAngle;
let randomX;
let hiddenScrew = true;
let screwClicks = 0;

function titleClick() {
    if (isFallingDown) {
        randomAngle = getRandomAngle();
        randomX = getRandomX()
        document.documentElement.style.setProperty('--random-angle', `${randomAngle}deg`);
        document.documentElement.style.setProperty('--random-x', `${randomX}vh`);
        title.classList.add('falling-down');
        
        setTimeout(() => {
            screw.removeAttribute("hidden");
        }, 100);
        hiddenScrew = false;
    } else {
        title.classList.remove('falling-down');
    }

    if (isGoingUp) {
        document.documentElement.style.setProperty('--random-angle', `${randomAngle}deg`);
        document.documentElement.style.setProperty('--random-x', `${randomX}vh`);
        title.classList.add('going-up');

        setTimeout(() => {
            screw.setAttribute("hidden", "true");
        }, 600);
        hiddenScrew = true;
    } else {
        title.classList.remove('going-up');
    }

    isFallingDown = !isFallingDown;
    isGoingUp = !isGoingUp;
}

function getRandomAngle() {
    return Math.floor(Math.random() * 90) - 45;
}

function getRandomX() {
    return Math.floor(Math.random() * 140) - 70;
}

function screwClick() {
    console.log("clicked")
    screwClicks++;
    var screwAngle = screwAngleCalc(screwClicks);
    document.documentElement.style.setProperty('--screw-angle', `${screwAngle}deg`);

    screwImg.classList.add('screwing');
    setTimeout(() => {
        screw.classList.remove('screwing');
    }, 500);
    if (screwClicks > 2) {
        screw.removeAttribute('onclick');
        title.removeAttribute('onclick');
        contentDiv.style.display = 'block';
        titleClick()
        document.body.style.cursor = 'url("screwCursor.png"), auto';
    }
}

function screwAngleCalc(screwClicks) {
    return 80*screwClicks; // Adjust this calculation as needed
}