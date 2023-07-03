const days = document.getElementById("days");
const month = document.getElementById("month");
const year = document.getElementById("year");

            let numOfDays = new Date(new Date().getFullYear(),new Date().getMonth()+1,0).getDate();
            let monthName = new Date().getMonth();
            let currentYear = new Date().getFullYear();
            

            for(let i = 0; i < numOfDays; i++)
            {
                let opt = document.createElement("option");
                opt.value = i+1;
                opt.text = i+1;        
                days.add(opt);
            }
            
            for(let i = 0; i < 12; i++)
            {
                let opt = document.createElement("option");
                opt.value = getMothName(i);
                opt.text = getMothName(i);        
                month.add(opt);
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
                    //alert("hi");
                   // return false;
                    
                    for(let i = 0; i < passwordLength; i++)
                    {
                        character = password.charAt(i);
                        
                        if(Number.isInteger(parseInt(character)))
                        {
                            isNum = true;
                            
                        }
                        //Check if the character is upper case 
                        else if(character == character.toUpperCase())
                        {
                            
                            isUppserCase = true;
                        }
                        //check if characte is lower case 
                        else if(character == character.toLowerCase())
                        {
                            isLowerCase = true;
                        }
                        //check if character is a special character 
                        
                        

                    }

                    if(isLowerCase && isUppserCase && isRequiredLength && isNum)
                    {
                           
                            return true;

                    }else 
                    {
                        alert("something went wrong ");
                        return false;   
                    }                    
                }
                else
                {
                    alert("Password must be a minimum of 6 characters");
                    return false;
                }
                /*
                function checkSpecialCharacters()
                {

                }
               */ 
            }