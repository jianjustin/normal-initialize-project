<template>
    <v-container fill-height style="height: calc(100vh - 58px);">
        <v-layout align-center>
            <v-flex text-center>
                <h1 class="display-2 primary--text">Whoops, 403</h1>
                <p>you are Forbidden！</p>
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
export default {
    name: 'FourOhFour',
    props: {
        lang: {
            type: String,
            default: 'en',
        },
    },
    created() {
        this.$ssrContext && this.$ssrContext.res.status(403)
    },
}
</script>