const days = document.getElementById("days");
const month = document.getElementById("month");
const year = document.getElementById("year");
const loginUsername = document.getElementById("username");

/*    
let session = window.sessionStorage.getItem("pass");
let username = window.sessionStorage.getItem("username");

    if(username.length !== 0)
    {
        loginUsername.value = username;
        alert("Incorrect log in details. Please provide correct log in datails");
    }*/
    let numOfDays = new Date(new Date().getFullYear(),new Date().getMonth()+1,0).getDate();
    let monthName = new Date().getMonth();
    let currentYear = new Date().getFullYear();
    let todaysDate = new Date();        
    
    for(let i = 0; i < numOfDays; i++)
    {
        let opt = document.createElement("option");
        opt.value = i+1;
        opt.text = i+1;        
        days.add(opt);
        if(opt.value === todaysDate.getDate()-1)
        {
            days.selectedIndex = todaysDate.getDate()-1;
        }  
    }
    
            
    for(let i = 0; i < 12; i++)
    {
        let opt = document.createElement("option");
        opt.value = i+1;
        opt.text = getMothName(i);        
        month.add(opt);
        if(opt.value === getMothName(todaysDate.getMonth()))
        {
            month.selectedIndex = todaysDate.getDate()-1;
        }
    }
    for(let i = currentYear ; i > 1904; i--)
    {
        let opt = document.createElement("option");
        opt.value = i;
        opt.text = i;        
        year.add(opt);

    }
            
    function getMothName(monthNumber)
    {
        let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        return months[monthNumber];
    }   
            
    function toogle()
    {
        let text = document.getElementById("text");
        let login = document.getElementById("login");
        let signUp = document.getElementById("sign-up");
        let page = document.getElementById("page");
        text.classList.toggle("blur");
        login.classList.toggle("blur");
        page.classList.toggle("blur");
        signUp.classList.toggle("visible");
    }

    function validateSignUp()
    {
        let firstname = document.forms["signUpform"]["firstname"].value;
        let password = document.forms["signUpform"]["password"].value;
        const signUpForm = document.getElementById("sign-up-form");
        let isUppserCase = false;
        let isLowerCase  = false;
        let isRequiredLength = false;
        let isSpecialChar = false;
        let isNum = false;
                
        let passwordLength = password.length;
        let character = ' ';
        if(passwordLength >= 6)
        {
        isRequiredLength = true;
                
                for(let i = 0; i < passwordLength; i++)
                {
                    character = password.charAt(i);
                    
                    if(Number.isInteger(parseInt(character)))
                    {
                        isNum = true;
                        
                    } 
                    else if(character == character.toUpperCase())
                    {
                        
                        isUppserCase = true;
                    }
                     
                    else if(character === character.toLowerCase())
                    {
                        isLowerCase = true;
                    }
                    
                }

                if(isLowerCase && isUppserCase && isRequiredLength && isNum)
                {
                    
                        return true;

                }else 
                {
                    signUpForm.preventDefault();
                    alert("something went wrong ");
                    return false;   
                }                    
            }
            else
            {
                signUpForm.preventDefault();
                alert("Password must be a minimum of 6 characters");
                return false;
            }          
    }
    
        function showPopUp()
        {
            let makePost = document.getElementById("post-visibility");

            makePost.classList.toggle("post-invisible");
            
        }
     
        function toogleHidden(id)
        {
            let notif = document.getElementById("notif-hidden");
            let notifBtn = document.getElementById("notif");
            let msgbtn = document.getElementById("msg-btn");
            let msgs = document.getElementById("msgs");
            let userAbout = document.getElementById("user-about");

            if(id == 'notifications')
            {
                notifBtn.classList.toggle("btn-active");
                notif.classList.toggle("hidden-visible");
                msgbtn.classList.remove("btn-active");
                msgs.classList.remove("hidden-visible");  
                userAbout.classList.remove("hidden-visible");

            }else if(id == 'messeges')
            {
                msgs.classList.toggle("hidden-visible");
                msgbtn.classList.toggle("btn-active");
                notifBtn.classList.remove("btn-active");
                notif.classList.remove("hidden-visible");
                userAbout.classList.remove("hidden-visible");

            }else if(id == 'user-about')
            {
                userAbout.classList.toggle("hidden-visible");
                notifBtn.classList.remove("btn-active");
                notif.classList.remove("hidden-visible");
                msgbtn.classList.remove("btn-active");
                msgs.classList.remove("hidden-visible");  
                
            }
            
        }