<!DOCTYPE html>
<%@ page language="java" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>解密</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container" id="example-1">

    value <input v-model="value" type="text" class="form-control"/>
    <br/>
    result <input v-model="result" type="text" class="form-control"/>
    <br/>
    <button @click="decrypt" class="btn btn-lg btn-primary btn-block">解密</button>

    <br/>
    <button @click="encrypt" class="btn btn-lg btn-primary btn-block">加密</button>

</div>
</body>
<script>
    var vm = new Vue({
        el: '#example-1',
        data: {

            value: "",
            key: "",
            result: ""
        },
        methods: {
            decrypt: function () {
                var _this = this;
                var _post = {action: "decrypt", value: this.value};
                axios.defaults.headers.post['Content-Type'] = 'application/json';

                axios.post('/utils/crypto.json', _post)
                    .then(function (response) {
                        // handle success
                        console.log(response);
                        _this.result = response.data.result
                        //alert(response.data.result)
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                        alert(error);
                        alert(error + "加密失败");
                    })
                    .then(function () {
                        // always executed
                    });
            },
            encrypt: function () {
                var _this = this;
                var _post = {action: "encrypt", value: this.value};
                axios.defaults.headers.post['Content-Type'] = 'application/json';
                axios.post('/utils/crypto.json', _post)
                    .then(function (response) {
                        // handle success
                        console.log(response);
                        _this.result = response.data.result
                        //alert(response.data.result)
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                        alert(error + "解密失败");
                    })
                    .then(function () {
                        // always executed
                    });
            }
        },

        computed: {}

    })
</script>

</html>