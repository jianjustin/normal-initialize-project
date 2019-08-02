<template>
    <v-app id="inspire">
        <Navigation></Navigation>
        <Appbar></Appbar>
        <v-content>
            <v-container fluid fill-height>
                <router-view></router-view>
            </v-container>
        </v-content>
    </v-app>
</template>
<script>
import Navigation from './components/Navigation.vue'
import Appbar from './components/Appbar.vue'
export default {
    props: {},
    components: {
        Navigation,
        Appbar
    },
    data: () => ({
    }),
}
</script>