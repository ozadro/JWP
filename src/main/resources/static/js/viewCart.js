function deleteAllFromCart(){
    $.ajax({
        url: '/deleteAllProduct',
        type: 'GET',
        success: function (data){
            window.location.reload();
        }

    })
}
let TotalPrice = document.getElementById("totalPrice").textContent;
const FUNDING_SOURCES = [
    paypal.FUNDING.PAYPAL
];
FUNDING_SOURCES.forEach(fundingSource => {
    paypal.Buttons({
        fundingSource,
        style: {
            layout: 'vertical',
            shape: 'rect',
            color: 'gold'
        },
        createOrder: function (data, actions) {
            // Set up the transaction details
            return actions.order.create({
                purchase_units: [{
                    amount: {
                        value: TotalPrice
                    }
                }]
            });
        },
        onApprove: function (data, actions) {
            // Capture the payment
            return actions.order.capture().then(function (details) {
                // Handle the payment success
                console.log('Payment complete');
                // Redirect or perform further actions
                $.ajax({
                    url: '/success',
                    type: 'POST',
                    success: function (data){
                        window.location.reload();
                    }

                })
            });
        }
    }).render('#paypal-button-container');
});