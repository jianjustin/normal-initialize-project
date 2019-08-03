<template>
    <v-app id="inspire">
        <v-content>
            <v-container fluid fill-height>
                <v-layout align-center justify-center>
                    <v-flex xs12 sm8 md4>
                        <v-card class="elevation-12">
                            <v-toolbar color="#ad1357" dark flat>
                                <v-toolbar-title>后台管理系统</v-toolbar-title>
                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field v-model="username" label="Login" name="username" prepend-icon="person" type="text"></v-text-field>
                                    <v-text-field v-model="password" label="Password" name="password" prepend-icon="lock" type="password"></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="#ad1357" v-on:click="login()">Login</v-btn>
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
    props: {
        source: String,
        username:"",
        password:"",
    },
    data: () => ({
        drawer: null,
    }),
    methods:{
      login(){
        alert(this.username);
      }
    }
}
</script>