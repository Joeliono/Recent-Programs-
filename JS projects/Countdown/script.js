const countdown = () => {
    const countDate = new Date('July 4, 2022, 00:00:00');
    const now = new Date().getTime();
    const gap = countDate - now;

    const second = 1000;
    const minute = second * 60;
    const hour = minute * 60;
    const day = hour * 24;

    const textDay = Math.floor(gap / day);
    console.log(textDay);
    const textHour = Math.floor((gap % day) / hour);
    console.log(textHour);
    const textMin = Math.floor((gap % hour) / minute);
    const textSec = Math.floor((gap % minute) / second);

    document.querySelector(".day").innerText = textDay;
    document.querySelector(".hour").innerText = textHour;
    document.querySelector(".minute").innerText = textMin;
    document.querySelector(".second").innerText = textSec;
  
};

setInterval(countdown, 1000);