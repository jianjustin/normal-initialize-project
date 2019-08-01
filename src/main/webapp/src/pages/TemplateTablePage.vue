<template>
    <v-layout align-start justify-center>
        <BasicTable></BasicTable>
        <BottomNavigation></BottomNavigation>
    </v-layout>
</template>
<script>
import BasicTable from '../components/BasicTable.vue'
import BottomNavigation from '../components/BottomNavigation.vue'
export default {
    name: "tablePage",
    components: {
        BasicTable,
        BottomNavigation
    },
    props: {
        source: String,
    },
    data: () => ({
        dialog: false,
    }),
}
</script>