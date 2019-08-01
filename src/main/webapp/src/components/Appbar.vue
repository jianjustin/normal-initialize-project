<template>
    <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" app color="pink darken-3" dark>
        <v-toolbar-title style="width: 300px" class="ml-0 pl-4">
            <v-app-bar-nav-icon @click.stop="setDrawer()"></v-app-bar-nav-icon>
            <span class="hidden-sm-and-down">后台管理</span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon>apps</v-icon>
        </v-btn>
        <v-btn icon>
            <v-icon>notifications</v-icon>
        </v-btn>
        <v-btn icon>
            <v-icon>logout</v-icon>
        </v-btn>
    </v-app-bar>
</template>
<script>
export default {
    props: {},
    data: () => ({}),
    methods: {
        setDrawer: function(){
            this.$store.state.drawer = !this.$store.state.drawer;
        }
    }
}
</script>