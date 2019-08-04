<template>
    <v-app id="inspire">
        <Navigation></Navigation>
        <Appbar></Appbar>
        <v-content>
            <v-container fluid fill-height xs12>
                <v-layout col>
                    <v-flex xs6>
                        <v-card class="ma-2">
                            <v-card-title>
                                <span class="title">已完成任务</span>
                            </v-card-title>
                            <v-divider></v-divider>
                            <v-card-actions>
                                <v-list class="transparent">
                                    <v-list-item>
                                        <v-list-item-title>
                                            <v-checkbox v-model="checkbox1" label="登录模块"></v-checkbox>
                                        </v-list-item-title>
                                    </v-list-item>
                                    <v-list-item>
                                        <v-list-item-title>
                                            <v-checkbox v-model="checkbox1" label="session管理"></v-checkbox>
                                        </v-list-item-title>
                                    </v-list-item>
                                    <v-list-item>
                                        <v-list-item-title>
                                            <v-checkbox v-model="checkbox1" label="列表数据加载"></v-checkbox>
                                        </v-list-item-title>
                                    </v-list-item>
                                </v-list>
                            </v-card-actions>
                        </v-card>
                    </v-flex>
                    <v-flex xs6>
                        <v-card class="ma-2">
                            <v-card-title>
                                <span class="title">待完成任务</span>
                            </v-card-title>
                            <v-divider></v-divider>
                            <v-card-actions>
                                <v-list class="transparent">
                                    <v-list-item>
                                        <v-list-item-title>
                                            <v-checkbox v-model="checkbox1" label="模块增删改查"></v-checkbox>
                                        </v-list-item-title>
                                    </v-list-item>
                                </v-list>
                            </v-card-actions>
                        </v-card>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>
    </v-app>
</template>
<script>
import Navigation from '../components/Navigation.vue'
import Appbar from '../components/Appbar.vue'
export default {
    props: {},
    components: {
        Navigation,
        Appbar
    },
    data: () => ({}),
}
</script>