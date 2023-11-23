function convertCurrency() {
    const usdInput = document.getElementById('usdInput');
    const cadInput = document.getElementById('cadInput');
    const usdCurrency = document.getElementById('usdCurrency').value;
    const cadCurrency = document.getElementById('cadCurrency').value;

    let result;

    console.log(usdCurrency,cadCurrency,usdInput.value,cadInput.value);

    if (usdCurrency === 'usd' && usdInput.value) {
        result = usdInput.value * 1.25; // assuming 1 USD = 1.25 CAD for demonstration
        cadInput.value = result;
    }
    // else if( cadCurrency === 'cad' && cadInput.value) {
    //     result = cadInput.value / 1.25; // assuming 1 USD = 1.25 CAD for demonstration
    //     usdInput.value = result;
    // }
    else if( usdCurrency === 'cad' && usdInput.value) {
        result = usdInput.value / 1.25; // assuming 1 USD = 1.25 CAD for demonstration
        cadInput.value = result;
    }


}
function change() {
if (document.getElementById('usdCurrency').value == 'usd'){
        document.getElementById("cadCurrency").value = 'usd';
    document.getElementById("cadInput").value = 0;
    document.getElementById("text1").innerText = 'Convert USD to CAD at the real exchange';

}
    
  else if (document.getElementById('usdCurrency').value == 'cad'){
        document.getElementById("cadInput").value = 0;
        document.getElementById("cadCurrency").value = 'usd';
         document.getElementById("text1").innerText = 'Convert CAD to USD at the real exchange';

  }

 };  