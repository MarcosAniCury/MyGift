
function chatbot() 
    {​​​​window.onload = function () 
        {
            ​​​​new BlipChat()
            .withAppKey('c2FjMzM6MGNmYjk4NDAtNmQzMy00ZThkLWFjMmQtYjU4OWM0OWJhODlm')
            .withButton({​​​​"color":"#55a8de","icon":""}​​​​)
            .withCustomCommonUrl('https://chat.blip.ai/?appKey=c2FjMzM6MGNmYjk4NDAtNmQzMy00ZThkLWFjMmQtYjU4OWM0OWJhODlm')
            .build();
        }​​​​
    };