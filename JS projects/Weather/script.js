window.addEventListener('load',()=>
{

    var icon = document.getElementById("icon1");
    var context = icon.getContext("2d");
    var myImg = new Image();
    let tdesc = document.querySelector('.temp-desc');
    let tdeg = document.querySelector('.degrees');
    let locationtz = document.querySelector('.location-timezone');
    let tempsec = document.querySelector('.temp');
    const tempspan = document.querySelector('.temp span');

    if(navigator.geolocation)
    {
        navigator.geolocation.getCurrentPosition(postion =>{
          long = postion.coords.longitude;
          lat = postion.coords.latitude;

          const proxy =`https://cors-anywhere.herokuapp.com/`;
          const api =`${proxy}http://api.weatherapi.com/v1/forecast.json?key=d21a07aaadaf462b89d100700221705&q=Leeds,West Yorkshire&days=1&aqi=no&alerts=no`;

          fetch(api)
          .then(response =>{
              return response.json();
          })
          .then(data => {
             console.log(data);
             const {temp_c, temp_f,condition} = data.current;
             const {region, localtime, name} = data.location;
             const {icon} = data.current.condition;
            
             tdeg.textContent = temp_c;
             tdesc.textContent = condition.text;
             locationtz.textContent = name + ' , '+region + " , "+ localtime;
             myImg.onload = function(){
                context.drawImage(myImg,0,0)
               };
               myImg.src = 'http://cdn.weatherapi.com/weather/64x64/day/116.png';
         
               tempsec.addEventListener('click',() =>{
                   if(tempspan.textContent === "°C")
                   {
                     tempspan.textContent = "°F";
                     tdeg.textContent = temp_f;
                   }
                   else{
                    tempspan.textContent = "°C";
                    tdeg.textContent = temp_c;
                   }
               });

          });

        });
      
    }
   
   
    
    
});