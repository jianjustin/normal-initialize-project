<template>
    <v-app id="inspire">
        <v-content>
            <v-container fluid fill-height>
                <v-layout align-center justify-center>
                    <v-flex xs12 sm8 md4>
                        <v-card class="elevation-12">
                            <v-toolbar :color="$store.state.color" dark flat>
                                <v-toolbar-title>后台管理系统</v-toolbar-title>
                            </v-toolbar>
                            <v-card-text>
                                <v-form id="login-form">
                                    <v-text-field v-model="username" name="username" prepend-icon="person" type="text"></v-text-field>
                                    <v-text-field v-model="password" name="password" prepend-icon="lock" type="password"></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn :color="$store.state.color" v-on:click="login()">Login</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>
    </v-app>
</template>
<script>
export default {
    props: {},
    data: () => ({
        drawer: null,
        username:"",
        password:"",
    }),
    methods:{
      login(){
        var _this = this;
        var arr="username="+this.username+"&password="+this.password;
        _this.axios.post('/api/login',arr)
            .then((response) => {
              _this.$store.state.token = response.data;
              this.$session.set("token",response.data);
              /* TODO 获取权限信息，进行路由过滤*/
              _this.$router.push("/");
            }).catch((error) => {
                console.log(error)
            });
        
      }
    }
}
</script>