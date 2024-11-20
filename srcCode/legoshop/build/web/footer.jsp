<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LegoShop</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Add the CSS styling here */
        .footer_area {
            background-color: #2c3e50;
            color: #ecf0f1;
            padding-top: 20px;
            padding-bottom: 20px;
            font-family: Arial, sans-serif;
            text-align: center; /* Center all text within the footer area */
        }

        .footer_top {
            border-bottom: 1px solid #34495e;
            padding-bottom: 20px;
            margin-bottom: 20px;
        }

        .footer_top h3 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .footer_top p {
            font-size: 14px;
            line-height: 1.6;
            margin-bottom: 10px;
        }

        .footer_widget_contect p,
        .footer_widget_contect a {
            font-size: 14px;
            line-height: 1.6;
            margin-bottom: 10px;
            color: #ecf0f1;
            text-decoration: none;
        }

        .footer_widget_contect i {
            margin-right: 10px;
        }

        .footer_bottom {
            padding-top: 10px;
        }

        .footer_bottom p {
            font-size: 12px;
            margin: 0;
        }

        .footer_bottom a {
            color: #3498db;
            text-decoration: none;
        }

        .footer_bottom a:hover {
            text-decoration: underline;
        }

        @media (max-width: 767px) {
            .footer_widget_contect p,
            .footer_widget_contect a {
                display: block;
                margin-bottom: 5px;
            }
        }
    </style>
</head>
<body>
    <div class="footer_area">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="footer_widget">
                            <h3>LegoShop</h3>
                            <p>Lựa chọn hàng đầu xu thế đồ chơi. Đến với chúng tôi để được hòa mình vào thế giới LEGO!</p>
                            <div class="footer_widget_contect">
                                <p><i class="fa fa-map-marker" aria-hidden="true"></i>  Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</p>
                                <p><i class="fa fa-mobile" aria-hidden="true"></i> 0(1234) 567 890</p>
                                <a href="#"><i class="fa fa-envelope-o" aria-hidden="true"></i> LegoShop@gmail.com </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer_bottom">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12 col-md-12">
                        <div class="copyright_area align-items-center">
                            <p>Copyright &copy; 2018 <a href="#">Start BootStrap</a>. All rights reserved. </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
