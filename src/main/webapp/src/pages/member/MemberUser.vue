<template>
  <v-app id="inspire">
    <Navigation></Navigation>
    <Appbar></Appbar>
    <v-content>
        <v-container fluid fill-height>
            <v-layout column>
                <v-card class="ma-2">
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn dark :color="$store.state.color">
                            <v-icon dark>edit</v-icon>
                        </v-btn>
                        <v-btn dark :color="$store.state.color">
                            <v-icon dark>add</v-icon>
                        </v-btn>
                        <v-btn dark :color="$store.state.color">
                            <v-icon dark>delete</v-icon>
                        </v-btn>
                    </v-card-actions>
                </v-card>
                <v-card class="ma-2">
                    <v-data-table :headers="headers" :items="desserts" item-key="name" show-select class="elevation-1">
                        <template>
                            <v-switch label="Single select" class="pa-3"></v-switch>
                        </template>
                    </v-data-table>
                </v-card>
            </v-layout>
        </v-container>
    </v-content>
  </v-app>
</template>
<script>
import Navigation from '../../components/Navigation.vue'
import Appbar from '../../components/Appbar.vue'
export default {
    props: {},
    components: {
        Navigation,
        Appbar
    },
    data: () => ({
        selected: [],
        headers: [{
                text: '用户编号',
                align: 'left',
                sortable: false,
                value: 'memberUserCode',
            },
            { text: '用户名称', value: 'memberUserName' },
            { text: '登录账号', value: 'memberUserLoginAccount' },
            { text: '手机号码', value: 'memberUserPhoneNumber' },
            { text: '邮箱', value: 'memberUserEmail' },
            { text: '创建时间', value: 'memberUserCreateDate' },
        ],
        desserts: [],
    }),
    mounted: function(){
        this.queryAllMemberUser();
    },
    methods:{
        queryAllMemberUser: function(){
          var _this = this;
          _this.axios({
              method:'POST',
              url: '/api/member/user/queryAll',
              headers: {'token': _this.$session.get("token")},
              data: {}
          }).then(function (response) {
            debugger;
            _this.desserts = response.data.domainList;
          }).catch(function () {
            console.log(error);
          });
        }
    }
}
</script>